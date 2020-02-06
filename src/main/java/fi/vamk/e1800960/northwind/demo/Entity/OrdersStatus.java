package fi.vamk.e1800960.northwind.demo.Entity;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "fi.vamk.e1800960.northwind.demo.Entity.OrdersStatus")
@Table(name = "orders_status")
public class OrdersStatus {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Byte id;
  @Column(name = "\"status_name\"", nullable = false)
  private String statusName;
}