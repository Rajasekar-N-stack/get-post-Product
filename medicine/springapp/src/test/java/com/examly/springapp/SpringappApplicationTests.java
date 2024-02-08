package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {
	@Autowired
    private MockMvc mockMvc;

    @Order(1)
	@Test
	public void testPostData() throws Exception {
		String st = "{\"medicineId\": 2, \"medicineName\": \"asthalin\", \"medicineFor\": \"Cold\", \"medicineBrand\": \"cipla\", \"manufacturedIn\": \"chennai\", \"medicinePrice\": 37.0, \"expiryDate\": \"2020-03-03\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/medicine")
				.contentType(MediaType.APPLICATION_JSON)
				.content(st)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn();
	}
	
    @Order(2)
    @Test
    public void testGetByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/medicine/2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Order(3)
    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/medicines")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();
    }

    @Order(4)
    @Test

   public void controllerfolder() {

       String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your directory

       File directory = new File(directoryPath);

       assertTrue(directory.exists() && directory.isDirectory());

   }

   @Order(5)
   @Test

   public void controllerfile() {

       String filePath = "src/main/java/com/examly/springapp/controller/MedicineController.java";

       File file = new File(filePath);

       assertTrue(file.exists() && file.isFile());

   }

   @Order(6)
   @Test

   public void testModelFolder() {

       String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory

       File directory = new File(directoryPath);

       assertTrue(directory.exists() && directory.isDirectory());

   }

   @Order(7)
   @Test

   public void testModelFile() {

       String filePath = "src/main/java/com/examly/springapp/model/Medicine.java";

       File file = new File(filePath);

       assertTrue(file.exists() && file.isFile());

   }


   @Order(8)
   @Test

   public void testrepositoryfolder() {

       String directoryPath = "src/main/java/com/examly/springapp/repository"; // Replace with the path to your directory

       File directory = new File(directoryPath);

       assertTrue(directory.exists() && directory.isDirectory());

   }

  
   @Order(9)
   @Test

   public void testrepositoryFile() {

       String filePath = "src/main/java/com/examly/springapp/repository/MedicineRepo.java";

       // Replace with the path to your file

       File file = new File(filePath);

       assertTrue(file.exists() && file.isFile());

   }


   
   @Order(10)
   @Test

   public void testServiceFolder() {

       String directoryPath = "src/main/java/com/examly/springapp/service"; 

       File directory = new File(directoryPath);

       assertTrue(directory.exists() && directory.isDirectory());

   }

  
   @Order(11)
   @Test

   public void testServieFile() {

       String filePath = "src/main/java/com/examly/springapp/service/MedicineService.java";

       // Replace with the path to your file

       File file = new File(filePath);

       assertTrue(file.exists() && file.isFile());

   }



    

 


}
