# codezp-ad-springcloud
### 广告系统



#### 项目结构

>codezp-ad-springcloud-------------------------------------父项目
>
>>ad-eureka---------------------------------------------------服务注册与服务发现（eureka）
>>
>>ad-gateway-------------------------------------------------网关（zuul）
>>
>>ad-service---------------------------------------------------广告服务的父项目
>>
>>>ad-common--------------------------------------------通用代码部分（全局异常处理、返回数据统一格式）
>>>
>>>ad-search-----------------------------------------------广告检索服务（数据索引、binlog）
>>>
>>>ad-sponsor--------------------------------------------广告投放服务



![image-20200803132615531](https://raw.githubusercontent.com/Gentleelephant/picgo/master/img/20200803132622.png)



**查询数据表的各种信息**

```SQL
SELECT	table_schema,TABLE_NAME,COLUMN_NAME,ordinal_position	FROM	information_schema.columns WHERE table_schema = 'ad_data' AND TABLE_NAME='ad_unit_keyword'
```

*ad_unit_keyword表的结构*

![image-20200805121752343](https://raw.githubusercontent.com/Gentleelephant/picgo/master/img/20200805121752.png)

*查询出来的ad_unit_keyword表的信息*

![image-20200805121648692](C:\Users\张鹏\AppData\Roaming\Typora\typora-user-images\image-20200805121648692.png)





索引部分

索引实际上就是Map

>索引实体类
>
>* `AdPlanObject`  		           推广计划索引实体类
>* `AdUnitObject`                     推广单元索引实体类
>* `CreativeObject`                 推广创意索引实体类
>* `CreativeUnitObject`         创意与推广单元关联索引实体类
>* `UnitDistrictObject`         地域推广单元索引实体类
>* `UnitItObject`                      兴趣推广单元索引实体类
>* `UnitKeywordObject`            关键词推广单元索引实体类
>
>索引操作接口（增、删、改、查)
>
>```java
>/**
>* 索引接口，增、删、改、查
>*/
>public interface IndexAware<K, V> {
>   /**
>    * 获得索引
>    * @param key
>    * @return
>    */
>   V get(K key);
>   /**
>    * 添加索引
>    * @param key
>    * @param value
>    */
>   void add(K key, V value);
>   /**
>    * 更新索引
>    * @param key
>    * @param value
>    */
>   void update(K key, V value);
>   /**
>    * 删除索引
>    * @param key
>    * @param value
>    */
>   void delete(K key, V value);
>}
>```
>
>索引操作实体类
>
>* AdPlanIndex					推广计划索引操作实体类
>* AdUnitIndex                    推广单元索引操作实体类
>* CreativeIndex                  创意索引操作实体类
>* CreativeUnitIndex          创意与推广单元关联索引操作实体类
>* UnitDistrictIndex            地域推广单元索引操作实体类
>* UnitItIndex                       兴趣推广单元索引操作实体类
>* UnitKeywordIndex          关键字推广单元索引操作实体类

BinLog部分

**什么是binlog？**

*binlog是一个二进制格式的文件，用于记录用户对数据库更新的SQL语句信息，例如更改数据库表和更改内容的SQL语句都会记录到binlog里，但是对库表等内容的查询不会记录默认情况下，binlog日志是二进制格式的，不能使用查看文本工具的命令（比如，cat，vi等）查看，而使用mysqlbinlog解析查看。*

**binlog的作用**

*当有数据写入到数据库时，还会同时把更新的SQL语句写入到对应的binlog文件里，这个文件就是上文说的binlog文件。使用mysqldump备份时，只是对一段时间的数据进行全备，但是如果备份后突然发现数据库服务器故障，这个时候就要用到binlog的日志了。主要作用是用于数据库的主从复制及数据的增量恢复。*

**template.json文件描述数据库的以及其中表的结构**

```json
{
  "database": "ad_data",
  "tableList": [
    {
      "tableName": "ad_plan",
      "level": 2,
      "insert": [
        {"column": "id"},
        {"column": "user_id"},
        {"column": "plan_status"},
        {"column": "start_date"},
        {"column": "end_date"}
      ],
      "update": [
        {"column": "id"},
        {"column": "user_id"},
        {"column": "plan_status"},
        {"column": "start_date"},
        {"column": "end_date"}
      ],
      "delete": [
        {"column": "id"}
      ]
    },
    {
      "tableName": "ad_unit",
      "level": 3,
      "insert": [
        {"column": "id"},
        {"column": "unit_status"},
        {"column": "position_type"},
        {"column": "plan_id"}
      ],
      "update": [
        {"column": "id"},
        {"column": "unit_status"},
        {"column": "position_type"},
        {"column": "plan_id"}
      ],
      "delete": [
        {"column": "id"}
      ]
    },
    {
      "tableName": "ad_creative",
      "level": 2,
      "insert": [
        {"column": "id"},
        {"column": "type"},
        {"column": "material_type"},
        {"column": "height"},
        {"column": "width"},
        {"column": "audit_status"},
        {"column": "url"}
      ],
      "update": [
        {"column": "id"},
        {"column": "type"},
        {"column": "material_type"},
        {"column": "height"},
        {"column": "width"},
        {"column": "audit_status"},
        {"column": "url"}
      ],
      "delete": [
        {"column": "id"}
      ]
    },
    {
      "tableName": "creative_unit",
      "level": 3,
      "insert": [
        {"column": "creative_id"},
        {"column": "unit_id"}
      ],
      "update": [
      ],
      "delete": [
        {"column": "creative_id"},
        {"column": "unit_id"}
      ]
    },
    {
      "tableName": "ad_unit_district",
      "level": 4,
      "insert": [
        {"column": "unit_id"},
        {"column": "province"},
        {"column": "city"}
      ],
      "update": [
      ],
      "delete": [
        {"column": "unit_id"},
        {"column": "province"},
        {"column": "city"}
      ]
    },
    {
      "tableName": "ad_unit_it",
      "level": 4,
      "insert": [
        {"column": "unit_id"},
        {"column": "it_tag"}
      ],
      "update": [
      ],
      "delete": [
        {"column": "unit_id"},
        {"column": "it_tag"}
      ]
    },
    {
      "tableName": "ad_unit_keyword",
      "level": 4,
      "insert": [
        {"column": "unit_id"},
        {"column": "keyword"}
      ],
      "update": [
      ],
      "delete": [
        {"column": "unit_id"},
        {"column": "keyword"}
      ]
    }
  ]
}

```

>Template
>
>JsonTable
>
>TableTemplate
>
>ParseTemplate
>
>BinlogRowData
>
>MySqlRowData

**binlog相关操作**

>Ilistener
>
>IncrementListener
>
>AggregationListener
>
>BinlogClient
>
>BinlogConfig
>
>TemplateHolder
**@author:coderzpg**
