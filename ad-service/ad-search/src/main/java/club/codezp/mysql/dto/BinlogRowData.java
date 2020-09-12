package club.codezp.mysql.dto;

import com.github.shyiko.mysql.binlog.event.EventType;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 解析binlog数据row数据
 */
@Data
public class BinlogRowData {

    private TableTemplate table;

    /**
     * 操作类型
     */
    private EventType eventType;

    /**
     * 只有update操作有fater和before数据，但是为了统一还是加上了
     */
    private List<Map<String, String>> after;

    private List<Map<String, String>> before;
}
