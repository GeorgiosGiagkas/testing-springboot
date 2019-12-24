-Why do we need mocking?
Unit testing in layers(example businness, data). We do not need to worry about
other layers when we test for one layer!!

We write test with multiple senarios!

Stub implementation of a service  is not vary convenient.
Stubs are hard to maintain
->To counter this problem use mocking!

mock() -> creates an 'example' of specific interface

Use @BeforeEace and create a method that is called before each method test(BeforeEach inJUnit5, Before in JUnit4)

**
Cunstructor injection VS Setter Injection
!!Cuation with annotation
@Mock
@InjectMock
@RunWith(MockitoJUnitRunner.class)
https://tedvinke.wordpress.com/2014/02/13/mockito-why-you-should-not-use-injectmocks-annotation-to-autowire-fields/
**

Use thenReturn() for multiple assertions

Use Argumentmatchers to match any argument. Example anyInt()


Use verify() to check if a method inside tested method is called.
Also verify number of times  called.

Use ArgumentCaptor to capture argument passed as parameters in a method call.

When we create Mock, the entiry behavior of the interface is lost!! So,
we can use Spy instead, to keep behavior.


Spring Mock MVC framework

Testing Controllers:
@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)

Then Autowire MockMvc which does the request. But, you need to build the request using MockMvcRequestBuilders.get("/url").accept(MediaType.APPLICATION_JSON).
Then return the result as MvcResult by doing the call mockMvc.performe(requestBuilder).andReturn()
To make assertions get the content to string: mvcResult.getResponse().getContentAsString()

Use MockMvcResultMatchers to expect status and content in simple requests when using perform()


Use JSONAssert.
Strict == True will take into consideration the Structure of JSON(exept spaces).
StricT ==False will check only for key:values. Also format does not need escape characters.(however, use escape if the value has spaces)

Use @MockBean to mock a service when testing a controller.

Create a data.sql in resources folder to initialize the in memory database H2 and have populated data. ** You can also create /test/resources and  move data.sql to that folder in order to test each time using data-test.sql!

Use @DataJpaTest in repository testing, and Autowire TestEntityManager!

Testing Busness layer does not "interact" with spring.


Create Integration Tests (ITs) combining all layers(web,business,data)
So, in integration tests we want to launch the app with all the component(web,business,data)
using @SpringBootTest.
For instance, for MyControllerIT, annotate with @SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
to load in a "free" port.Autowire TestRestTemplate to be able to send request to the MyControllerIT and get the response!

Mock "out" external dependencies using @MockBean

Configurations:
You can create a test/resources/application.properties to override what is configured in main/resourses/application.properties.
-or-
You can also create a test/resources/test-configuration.properties and add annotation:
@TestPropertySource(locations={"classpath:test-configuration.properties"}) -->Highest priority!

How to test other request methods:
Example POST
----Start CODE----
RequestBuilder requestBuilder = MockMvcRequestBuilders
	       .post("/items")
	       .accept(MEDIATYPE.APPLICATION_JSON)
	       .content("{id:1,name:Ball,price:10,quantity:20}")
	       .contentType(MEDIATYPE.APPLICAITON_JSON);

MvcResult result = mockMcv.perform(requestBuilder)
	  	 .andExpect(status().isCreated())
		 .andExpect(header().string("location",containsString("/item/")))
		 .andReturn();

---End Code---


Matching Libraries:
1.Hamcrest
import static org.hamcrest.*
2.AssertJ(better, uses method chaining)
import static org.assertj.core.api.Assertions.AssertThat;
3.JsonPath (make "queries" in the json response!!)
https://github.com/json-path/JsonPath

REcomended reading:
http://xunitpatterns.com

100% coverage does not guaranteed that the app is fully tested (does not necesserily find all defects)
Coverege is important only when it comes with proper asserts.

Test Performance:
Testing Data layer is moderetely fast cause the inmemory database must load
Testing Business layer is the faster.
Testing Web layer is the slowest as the Spring web-app context must load.


Good unit Tests:
1.Readable
2.Run Fast
3.Run often
4.Isolated
