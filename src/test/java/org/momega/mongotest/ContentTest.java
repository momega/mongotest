/**
 * 
 */
package org.momega.mongotest;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.momega.mongotest.config.TestConfiguration;
import org.momega.mongotest.model.Document;
import org.momega.mongotest.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class ContentTest {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Test
	public void simple() throws IOException {
		Document d = new Document();
		byte[] content = IOUtils.toByteArray(new ClassPathResource("file.txt").getInputStream());
		d.setContent(content);
		
		d = documentRepository.save(d);
		
		d = documentRepository.findOne(d.getId());
		
		Assert.assertEquals(new String(content), new String(d.getContent()));
	}
}
