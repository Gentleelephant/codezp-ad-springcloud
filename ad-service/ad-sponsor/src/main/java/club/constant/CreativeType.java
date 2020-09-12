package club.constant;

import lombok.Getter;

/**
 * @Author:Zpg
 * @Date:2020/8/1 22:14
 * @Version:1.0
 * @Description: 创意的类型
 */
@Getter
public enum  CreativeType {

    IMAGE(1,"图片"),
    VIDEO(2,"视频"),
    TEXT(3,"文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
