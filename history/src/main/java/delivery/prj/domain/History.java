package delivery.prj.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="History_table")
@Data
public class History {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private Long userId;
        private Long storeId;
        private Long menuId;
        private String qty;
        private String orderStatus;
        private String storeStatus;
        private String deliveryStatus;


}
