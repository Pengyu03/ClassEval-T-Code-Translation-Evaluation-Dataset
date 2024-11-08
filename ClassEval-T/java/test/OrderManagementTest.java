package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderManagementTest {

    private OrderManagement OrderManagement;

    @BeforeEach
    public void setUp() {
        OrderManagement = new OrderManagement();
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 5);
        OrderManagement.menu.add(dish1);

        Map<String, Object> dish2 = new HashMap<>();
        dish2.put("dish", "dish2");
        dish2.put("price", 15.0);
        dish2.put("count", 3);
        OrderManagement.menu.add(dish2);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 7);
        OrderManagement.menu.add(dish3);

        OrderManagement.sales.put("dish1", 0.9);
        OrderManagement.sales.put("dish2", 1.0);
        OrderManagement.sales.put("dish3", 0.8);
    }

    @Test
    public void testAddDish1() {
        Map<String, Object> dish = new HashMap<>();
        dish.put("dish", "dish3");
        dish.put("price", 15.0);
        dish.put("count", 4);
        assertTrue(OrderManagement.addDish(dish));
        assertEquals(3, OrderManagement.menu.get(2).get("count"));
        assertEquals(1, OrderManagement.selectedDishes.size());
    }

    @Test
    public void testAddDish2() {
        Map<String, Object> dish = new HashMap<>();
        dish.put("dish", "dish3");
        dish.put("price", 15.0);
        dish.put("count", 8);
        assertFalse(OrderManagement.addDish(dish));
        assertEquals(7, OrderManagement.menu.get(2).get("count"));
        assertEquals(0, OrderManagement.selectedDishes.size());
    }

    @Test
    public void testAddDish3() {
        Map<String, Object> dish = new HashMap<>();
        dish.put("dish", "dish3");
        dish.put("price", 15.0);
        dish.put("count", 7);
        assertTrue(OrderManagement.addDish(dish));
        assertEquals(0, OrderManagement.menu.get(2).get("count"));
        assertEquals(1, OrderManagement.selectedDishes.size());
    }

    @Test
    public void testAddDish4() {
        Map<String, Object> dish = new HashMap<>();
        dish.put("dish", "dish3");
        dish.put("price", 15.0);
        dish.put("count", 6);
        assertTrue(OrderManagement.addDish(dish));
        assertEquals(1, OrderManagement.menu.get(2).get("count"));
        assertEquals(1, OrderManagement.selectedDishes.size());
    }

    @Test
    public void testAddDish5() {
        Map<String, Object> dish = new HashMap<>();
        dish.put("dish", "dish3");
        dish.put("price", 15.0);
        dish.put("count", 5);
        assertTrue(OrderManagement.addDish(dish));
        assertEquals(2, OrderManagement.menu.get(2).get("count"));
        assertEquals(1, OrderManagement.selectedDishes.size());
    }
    @Test
    public void testAddDish6() {
        OrderManagement.menu.clear(); // 清空菜单
        Map<String, Object> dish = new HashMap<>();
        dish.put("dish", "pizza"); // 添加必要的键
        dish.put("price", 10.0);
        dish.put("count", 1);

        // 添加测试数据到菜单中
        OrderManagement.menu.add(dish);

        // 验证 addDish 方法返回值
        assertTrue(OrderManagement.addDish(dish));
    }

    @Test
    public void testCalculateTotal1() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 2);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 2);
        OrderManagement.addDish(dish3);

        assertEquals(50.0, OrderManagement.calculateTotal());
    }

    @Test
    public void testCalculateTotal2() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 2);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish2 = new HashMap<>();
        dish2.put("dish", "dish2");
        dish2.put("price", 15.0);
        dish2.put("count", 2);
        OrderManagement.addDish(dish2);

        assertEquals(48.0, OrderManagement.calculateTotal());
    }

    @Test
    public void testCalculateTotal3() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 1);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 1);
        OrderManagement.addDish(dish3);

        assertEquals(25.0, OrderManagement.calculateTotal());
    }

    @Test
    public void testCalculateTotal4() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 3);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 3);
        OrderManagement.addDish(dish3);

        assertEquals(75.0, OrderManagement.calculateTotal());
    }

    @Test
    public void testCalculateTotal5() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 4);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 4);
        OrderManagement.addDish(dish3);

        assertEquals(100.0, OrderManagement.calculateTotal());
    }

    @Test
    public void testCheckout1() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 2);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 2);
        OrderManagement.addDish(dish3);

        assertEquals(50.0, OrderManagement.checkout());
        assertTrue(OrderManagement.selectedDishes.isEmpty());
        assertEquals(3, OrderManagement.menu.get(0).get("count"));
        assertEquals(5, OrderManagement.menu.get(2).get("count"));
    }

    @Test
    public void testCheckout2() {
        assertFalse(OrderManagement.checkout() instanceof Double);
    }

    @Test
    public void testCheckout3() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 1);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 1);
        OrderManagement.addDish(dish3);

        assertEquals(25.0, OrderManagement.checkout());
        assertTrue(OrderManagement.selectedDishes.isEmpty());
        assertEquals(4, OrderManagement.menu.get(0).get("count"));
        assertEquals(6, OrderManagement.menu.get(2).get("count"));
    }

    @Test
    public void testCheckout4() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 3);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 3);
        OrderManagement.addDish(dish3);

        assertEquals(75.0, OrderManagement.checkout());
        assertTrue(OrderManagement.selectedDishes.isEmpty());
        assertEquals(2, OrderManagement.menu.get(0).get("count"));
        assertEquals(4, OrderManagement.menu.get(2).get("count"));
    }

    @Test
    public void testCheckout5() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 5);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 5);
        OrderManagement.addDish(dish3);

        assertEquals(125.0, OrderManagement.checkout());
        assertTrue(OrderManagement.selectedDishes.isEmpty());
        assertEquals(0, OrderManagement.menu.get(0).get("count"));
        assertEquals(2, OrderManagement.menu.get(2).get("count"));
    }

    @Test
    public void testOrderManagement() {
        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("dish", "dish1");
        dish1.put("price", 10.0);
        dish1.put("count", 2);
        OrderManagement.addDish(dish1);

        Map<String, Object> dish3 = new HashMap<>();
        dish3.put("dish", "dish3");
        dish3.put("price", 20.0);
        dish3.put("count", 2);
        OrderManagement.addDish(dish3);

        assertEquals(50.0, OrderManagement.checkout());
        assertTrue(OrderManagement.selectedDishes.isEmpty());
        assertEquals(3, OrderManagement.menu.get(0).get("count"));
        assertEquals(5, OrderManagement.menu.get(2).get("count"));
    }
}