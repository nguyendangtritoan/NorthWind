package fi.vamk.e1800960.northwind.demo.Entity;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "fi.vamk.e1800960.northwind.demo.Entity.PurchaseOrderStatus")
@Table(name = "purchase_order_status")
public class PurchaseOrderStatus {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"status\"", nullable = true)
  private String status;
}