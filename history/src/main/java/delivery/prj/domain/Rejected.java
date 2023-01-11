package delivery.prj.domain;

import delivery.prj.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Rejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long menuId;
    private String qty;
    private String status;
    private String address;
}
