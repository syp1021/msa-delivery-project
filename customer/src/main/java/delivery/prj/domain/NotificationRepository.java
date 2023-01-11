package delivery.prj.domain;

import delivery.prj.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="notifications", path="notifications")
public interface NotificationRepository extends PagingAndSortingRepository<Notification, Long>{

}
