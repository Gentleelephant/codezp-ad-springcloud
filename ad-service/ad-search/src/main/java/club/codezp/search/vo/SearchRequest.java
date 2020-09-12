package club.codezp.search.vo;

import club.codezp.search.vo.feature.DistrictFeature;
import club.codezp.search.vo.feature.FeatureRelation;
import club.codezp.search.vo.feature.ItFeature;
import club.codezp.search.vo.feature.KeywordFeature;
import club.codezp.search.vo.media.AdSlot;
import club.codezp.search.vo.media.App;
import club.codezp.search.vo.media.Device;
import club.codezp.search.vo.media.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 媒体方的请求：包含三部分
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {



    /**
     *     媒体方的请求标识
     */
    private String mediaId;

    /**
     *     请求基本信息
     */
    private RequestInfo requestInfo;

    /**
     *     匹配信息
     */
    private FeatureInfo featureInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestInfo {

        private String requestId;

        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;
        private DistrictFeature districtFeature;
        private ItFeature itFeature;

        private FeatureRelation relation = FeatureRelation.AND;
    }
}
