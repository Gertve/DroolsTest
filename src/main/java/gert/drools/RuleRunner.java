package gert.drools;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.io.FileInputStream;
import java.util.Collection;

/**
 * Created by Gert van Emmenes on 2016/05/13.
 */
public class RuleRunner {

//    public void runRules(String[] rules, Object[] facts) throws Exception {
////
////        KieServices ks = KieServices.Factory.get();
////
////        KieContainer kc = ks.getKieClasspathContainer();
////        KieSession ksession = kc.newKieSession("HelloWorldKS");
//
//        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//
//
//
//        for ( int i = 0; i < rules.length; i++ ) {
//            String ruleFile = rules[i];
//            System.out.println( "Loading file: " + ruleFile );
//            kbuilder.add( ResourceFactory.newClassPathResource( ruleFile, RuleRunner.class ), ResourceType.DRL );
//        }
//
//        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
//        kbase.addKnowledgePackages( pkgs );
//        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//
//        for ( int i = 0; i < facts.length; i++ ) {
//            Object fact = facts[i];
//            System.out.println( "Inserting fact: " + fact );
//            ksession.insert( fact );
//        }
//
//        ksession.fireAllRules();
//    }

    public void runRules(String[] rules, Object[] facts) throws Exception {

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write(ResourceFactory.newClassPathResource(rules[0])); // Or maybe a file system resource?
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            // Do something with the error messages. Log them perhaps...
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieSession kieSession = kieContainer.newKieSession();

        for ( int i = 0; i < facts.length; i++ ) {
            Object fact = facts[i];
            kieSession.insert( fact );
        }

        kieSession.fireAllRules();



    }
}
