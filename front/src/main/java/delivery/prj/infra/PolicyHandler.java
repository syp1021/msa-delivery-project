package delivery.prj.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import delivery.prj.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import delivery.prj.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_UpdateOrderStatus(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStarted'")
    public void wheneverCookStarted_UpdateOrderStatus(@Payload CookStarted cookStarted){

        CookStarted event = cookStarted;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + cookStarted + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookFinished'")
    public void wheneverCookFinished_UpdateOrderStatus(@Payload CookFinished cookFinished){

        CookFinished event = cookFinished;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + cookFinished + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_UpdateOrderStatus(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + accepted + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_UpdateOrderStatus(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + rejected + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }

}


