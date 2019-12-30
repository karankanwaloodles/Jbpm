package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;

/**
 * This is a sample file to test a process.
 */
public class ProcessTest extends JbpmJUnitBaseTestCase {

	@Test
	public void testProcess() {
		RuntimeManager manager = createRuntimeManager("sample.bpmn");
		RuntimeEngine engine = getRuntimeEngine(null);
		KieSession ksession = engine.getKieSession();
		Map<String, Object> params = new HashMap<String, Object>();  
        params.put("income", 1500);  
        System.out.println("params : "+params);
		ProcessInstance processInstance = ksession.startProcess("com.sample.bpmn.hello", params);
		// check whether the process instance has completed successfully
//		System.out.println("process Instance 1 :: "+processInstance.getId());
		assertProcessInstanceCompleted(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), "IdentityTest");
//		System.out.println("process Instance :: "+processInstance.getId());
		manager.disposeRuntimeEngine(engine);
		manager.close();
		
//		try {  
//            // load up the knowledge base  
//            KnowledgeBase kbase = readKnowledgeBase();  
//            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();  
//            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");  
//  
//            Map<String, Object> params = new HashMap<String, Object>();  
//            params.put("income", 1500);  
//            // start a new process instance  
//            ksession.startProcess("joe.ruleflow", params);  
//  
//            logger.close();  
//        } catch (Throwable t) {  
//            t.printStackTrace();  
//        }  
	}

}