package com.maldivati.apigateway_service.infraestructure.persistence;

import com.maldivati.apigateway_service.application.dto.RouteManagerDto;
import com.maldivati.apigateway_service.application.port.in.RouteManagerService;
import com.maldivati.apigateway_service.application.port.out.ApiResponseDto;
import com.maldivati.apigateway_service.domain.model.entity.RouteManagerEntity;
import com.maldivati.apigateway_service.domain.model.enums.ErrorCode;
import com.maldivati.apigateway_service.domain.model.enums.SuccessCodeEnum;
import com.maldivati.apigateway_service.domain.repository.RouteManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class RouteManagerServiceImpl implements RouteManagerService {
    private final RouteManagerRepository routeManagerRepository;

    public RouteManagerServiceImpl(RouteManagerRepository routeManagerRepository) {
        this.routeManagerRepository = routeManagerRepository;
    }

    @Override
    public ApiResponseDto createRoute(RouteManagerDto dto) {
        try {
            RouteManagerEntity accountEntity = saveOrUpdateRouter(dto);

            return ApiResponseDto.success(accountEntity, SuccessCodeEnum.USER_CREATED);
        } catch (IllegalArgumentException e) {

            return ApiResponseDto.error(null, ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (Exception e) {
            return ApiResponseDto.error(null, ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public ApiResponseDto readRoute(UUID id) {
        return null;
    }

    @Override
    public ApiResponseDto updateRoute(UUID id, RouteManagerDto dto) {
        return null;
    }

    private RouteManagerEntity saveOrUpdateRouter(RouteManagerDto dto) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime expirationDate = currentDateTime.plusYears(1);

        RouteManagerEntity entity = new RouteManagerEntity();
        entity.setCreationDate(currentDateTime.toString());
        entity.setExpirationDate(expirationDate.toString());

        // Utilizamos un método común para mapear los datos
        mapToEntity(dto, entity);

        return routeManagerRepository.save(entity);
    }
    private void mapToEntity(RouteManagerDto dto, RouteManagerEntity entity) {

        entity.setServiceName(dto.getServiceName());
        entity.setDescriptiveName(dto.getDescriptiveName());
        entity.setMethod(dto.getMethod());
        entity.setProtocol(dto.getProtocol());
        entity.setUri(dto.getUri());
        entity.setPort(dto.getPort());
        entity.setPredicates(dto.getPredicates());
        entity.setFilters(dto.getFilters());
        entity.setEndpoint(dto.getEndpoint());
    }
}
