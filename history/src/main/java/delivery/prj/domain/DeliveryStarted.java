package delivery.prj.domain;

import delivery.prj.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long menuId;
    private String riderId;
    private String address;
    private String status;
}
