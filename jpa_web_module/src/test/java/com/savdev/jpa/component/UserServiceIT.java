package com.savdev.jpa.component;

import java.io.File;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.savdev.api.User;

/**
 *
 */
@RunWith(Arquillian.class)
public class UserServiceIT {

    @Inject
    UserService userService;

    public static final long existingUser1Id = 5L;
    public static final long existingUser2Id = 10L;
    public static final String existingUser1Name = "comment_2_value";
    public static final String existingUser2Name = "comment_3_value";

    @Deployment
    public static WebArchive createDeployment() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("tests");
        String baseDir = resourceBundle.getString("basedir");
        //file must exist in target folder
//        WebArchive war = ShrinkWrap.createFromZipFile(WebArchive.class, new File( baseDir + File.separator + "target" +
//                File.separator + "jpa_web.war"));
//        System.out.println(war.toString(true));
//        return war;

        File[] files = Maven.resolver().loadPomFromFile(baseDir + File.separator + "pom.xml")
                .importDependencies(ScopeType.COMPILE).resolve().withTransitivity().asFile();
//
//        JavaArchive[] test = Maven.resolver().loadPomFromFile(baseDir + File.separator + "pom.xml")
//                .importDependencies(ScopeType.COMPILE).resolve().withTransitivity().as(JavaArchive.class);
//        JavaArchive q = test[6];


//        MavenDependencyResolver resolver = DependencyResolvers.use(
//                MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");

        WebArchive war = ShrinkWrap.create(WebArchive.class, "jpa_web.war")
                .addAsLibraries(files)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(war.toString(true));

        return war;
    }

//    @Test
//    public void should_create_greeting() {
//        Assert.assertEquals("test", "test");
//    }

    /*
        users should be loaded by liquibase when application starts up from csv file
     */
    @Test
    public void testLoadingUsersFromCvs() {
        User user = userService.find(existingUser1Id);
        Assert.assertEquals(existingUser1Name, user.getName());
//        if (true) return;
//        //users with
//        List<User> users = userService.findByIds(Lists.newArrayList(existingUser1Id, existingUser2Id));
//        Assert.assertEquals(2, users.size());
//        Assert.assertEquals(existingUser1Name, users.get(0).getName());
//        Assert.assertEquals(existingUser2Name, users.get(1).getName());
//        Assert.assertTrue(false);
    }
}
