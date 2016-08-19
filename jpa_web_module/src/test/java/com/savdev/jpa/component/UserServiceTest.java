package com.savdev.jpa.component;

import java.io.File;
import java.util.List;
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

import com.google.common.collect.Lists;
import com.savdev.api.User;

/**
 *
 */
@RunWith(Arquillian.class)
public class UserServiceTest {

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
        File[] files = Maven.resolver().loadPomFromFile(baseDir + File.separator + "pom.xml")
                .importDependencies(ScopeType.COMPILE, ScopeType.TEST, ScopeType.PROVIDED, ScopeType.RUNTIME, ScopeType.IMPORT).resolve().withTransitivity().asFile();

        WebArchive war = ShrinkWrap.create(WebArchive.class, "user_test.war")
                .addAsLibraries(files)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(war.toString(true));

        return war;
    }

    @Test
    public void should_create_greeting() {
        Assert.assertEquals("test", "test");
    }

    /*
        users should be loaded by liquibase when application starts up from csv file
     */
    @Test
    public void testLoadingUsersFromCvs() {
        //users with
        List<User> users = userService.findByIds(Lists.newArrayList(existingUser1Id, existingUser2Id));
        Assert.assertEquals(2, users.size());
        Assert.assertEquals(existingUser1Name, users.get(0).getName());
        Assert.assertEquals(existingUser2Name, users.get(1).getName());
        Assert.assertTrue(false);
    }
}
