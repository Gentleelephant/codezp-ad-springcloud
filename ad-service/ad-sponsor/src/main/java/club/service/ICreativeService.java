package club.service;


import club.vo.CreativeRequest;
import club.vo.CreativeResponse;

/**
 *
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
