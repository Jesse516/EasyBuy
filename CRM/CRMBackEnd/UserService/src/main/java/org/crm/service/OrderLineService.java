package org.crm.service;
import org.crm.domain.OrdersLine;
import java.util.List;

public interface OrderLineService {
    public List<OrdersLine> findlOrderLineById(int odd_order_id);
    public List<OrdersLine> findlOrderLine(int odd_order_id);
}
