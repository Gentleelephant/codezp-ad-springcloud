package club.codezp.search.vo;

import club.codezp.index.creative.CreativeObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 媒体放接受的响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {

    public Map<String, List<Creative>> adSlot2Ads = new HashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Creative {

        // 广告id
        private Long adId;
        // 广告的位置
        private String adUrl;
        // 广告的宽度
        private Integer width;
        //广告的高度
        private Integer height;
        // 广告的类型（便于让媒体放选择对应的解码器）
        private Integer type;
        private Integer materialType;

        // 展示监测 url
        private List<String> showMonitorUrl =
                Arrays.asList("www.codezp.club", "www.codezp.club");
        // 点击监测 url
        private List<String> clickMonitorUrl =
                Arrays.asList("www.codezp.club", "www.codezp.club");
    }

    /**
     * 实现把索引对象转换为返回的广告创意数据
     * @param object
     * @return
     */
    public static Creative convert(CreativeObject object) {

        Creative creative = new Creative();
        creative.setAdId(object.getAdId());
        creative.setAdUrl(object.getAdUrl());
        creative.setWidth(object.getWidth());
        creative.setHeight(object.getHeight());
        creative.setType(object.getType());
        creative.setMaterialType(object.getMaterialType());

        return creative;
    }
}
