package club.codezp.search;

import club.codezp.search.vo.SearchRequest;
import club.codezp.search.vo.SearchResponse;

/**
 *
 * 用于广告检索请求
 */
public interface ISearch {

    SearchResponse fetchAds(SearchRequest request);

}
