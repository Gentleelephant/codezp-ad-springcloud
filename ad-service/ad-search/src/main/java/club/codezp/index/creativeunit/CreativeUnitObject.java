package club.codezp.index.creativeunit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创意与推广单元关联索引实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitObject {

    /**
     * 创意对象ID
     */
    private Long adId;
    /**
     * 推广单元ID
     */
    private Long unitId;

    // adId-unitId
}
