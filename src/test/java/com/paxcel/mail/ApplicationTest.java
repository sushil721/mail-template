/*
 * package com.paxcel.mail;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.io.ClassPathResource; import
 * org.springframework.core.io.Resource; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper; import
 * com.paxcel.mail.model.ModelMain; import
 * com.paxcel.mail.service.HtmlGenerateServiceInterface;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * public class ApplicationTest {
 * 
 * private static Logger log = LoggerFactory.getLogger(ApplicationTest.class);
 * 
 * @Configuration
 * 
 * @ComponentScan(value="com.paxcel.mail") static class Config {
 * 
 * }
 * 
 * @Autowired private HtmlGenerateServiceInterface a;
 * 
 * 
 * @Test public void test() {
 * 
 * log.info("Before Object Get "); Resource resource = new
 * ClassPathResource("/static/newjson.json"); ModelMain modelMain = null; try {
 * ObjectMapper mapper = new ObjectMapper(); modelMain =
 * mapper.readValue(resource.getInputStream(), ModelMain.class); String
 * HTML_CONTENT = a.createHtmlTags(modelMain).toString();
 * log.info("After Object Get "); System.out.println(HTML_CONTENT);
 * 
 * }catch (Exception e) { log.info(e.getMessage()); }
 * 
 * } }
 * 
 */