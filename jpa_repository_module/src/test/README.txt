We do not want to use application server to test only repository services here.
TODO list for testing repotory services:
1. Create test for our repository service, see UserRepositoryServiceBeanTest
2. Initialize repository service with CrudService in test:
    this.userRepositoryServiceBean.crudService = RepositoryServiceTestHelper.getInstance().crudServiceInstance();
3. Create a persistence.xml file
    - set a persistence name
    - include entities you want to test
4. In order to use this persistence.xml file in test, add depenencies into the pom file:
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>eclipselink</artifactId>
            <version>2.5.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.derby</groupId>
            <artifactId>derby</artifactId>
            <version>10.9.1.0</version>
            <scope>test</scope>
        </dependency>
5. You must create a new EntityManager and start new transaction before each test and commit transaction after each test.
   Do it via RepositoryServiceTestBase base class for tests.
6. Run tests:
   mvn clean test

