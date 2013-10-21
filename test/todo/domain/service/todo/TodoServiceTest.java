/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todo.domain.service.todo;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import todo.domain.model.Todo;

/**
 *
 * @author hoi
 */
public class TodoServiceTest {
    
    private EJBContainer container;
    private Context context;
    
    public TodoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        context = container.getContext();
    }
    
    @After
    public void tearDown() {
        container.close();
    }

    /**
     * Test of findAll method, of class TodoService.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        TodoService instance = (TodoService)context.lookup("java:global/classes/TodoService");
        List<Todo> result = instance.findAll();
        System.out.println("result:" + result.size());
        for(int i=0;i < result.size();i++)
        {
            System.out.println("id:" + result.get(i).getTodoId());
        }
        assertNotNull(result);
    }

    /**
     * Test of findOne method, of class TodoService.
     */
    @Test
    public void testFindOne() throws Exception {
        System.out.println("findOne");
        Integer todoId = 1;
        TodoService instance = (TodoService)context.lookup("java:global/classes/TodoService");
        Todo result = instance.findOne(todoId);
        System.out.println(result);
        assertNotNull(result);
    }

    /**
     * Test of create method, of class TodoService.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Todo todo = new Todo(0);
        todo.setTodoTitle("testCreate:" + todo.getTodoId());
        TodoService instance = (TodoService)context.lookup("java:global/classes/TodoService");
        Todo result = instance.create(todo);
        System.out.println(result);
        assertNotNull(result);
    }

    /**
     * Test of finish method, of class TodoService.
     */
    @Test
    public void testFinish() throws Exception {
        System.out.println("finish");
        Integer todoId = 1;
        TodoService instance = (TodoService)context.lookup("java:global/classes/TodoService");
        Todo result = instance.finish(todoId);
        System.out.println(result);
        assertNotNull(result);
    }

    /**
     * Test of delete method, of class TodoService.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Integer todoId = 2;
        TodoService instance = (TodoService)context.lookup("java:global/classes/TodoService");
        instance.delete(todoId);

        System.out.println("deleted " + todoId);
    }
    
}
