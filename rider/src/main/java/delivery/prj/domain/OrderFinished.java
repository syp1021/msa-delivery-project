package delivery.prj.domain;

import delivery.prj.domain.*;
import delivery.prj.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long menuId;
    private String riderId;
    private String address;
    private String status;

    public OrderFinished(Delivery aggregate){
        super(aggregate);
    }
    public OrderFinished(){
        super();
    }
}
