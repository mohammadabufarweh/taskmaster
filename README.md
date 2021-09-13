# Taskmaster



**Task Master is an android application to manage daily tasks built by android studio.**
**Home page**

-  image to mock the “my tasks” view, and buttons at the bottom of the page to allow going to the “add tasks” and “all tasks” page.

![homepage.png](./homepage.png)

**All Tasks Page**

- The all tasks page just have an image with a back button.

![allTasks.png](./allTasks.png)

**Add Task page**

- On the “Add a Task” page, allow users to type in details about a new task, specifically a title and a body. When users click the “submit” button, show a “submitted!” label on the page.


![allTasks.png](./addtask.png)   ![allTasks.png](./submitted.png)



# Lab27 :

- **Homepage**


- homepage with three buttons Lab,Reading and Code Challenge Also Settings button ,when you press in settings button you will go to settings  page, and once the user has entered their username, it should display “{username}’s tasks” above the three task buttons.


![5.png](./5.png)      


- **settings  page**

![6.png](./6.png)   ![7.png](./7.png)


**Task Detail Page** 


- each page have taske come from button  hardcoded in home page
![3.png](./3.png)  ![2.png](./2.png)  ![1.png](./1.png)


# Lab28 :
- using a RecyclerView to displaying Task data


![8.png](./8.png)


# Lab 29
- Add task page

![9.png](./9.png)

- Home Page
![10.png](./10.png)


- Detail Page
![11.png](./11.png)


# Lab 31
# Espresso Testing

```java
  @Test public void testBtnAddTaskAndAllTask(){

        onView(withId(R.id.addTask)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.allTask)).perform(click());
        

    }
```
- in this test , we test the addTask button and allTask button in Home Page
- Home Page
![10.png](./10.png)


# Lab 32

- AWS Amplify is a set of tools and services that can be used together or on their own, to help front-end web and mobile developers build scalable full stack applications, powered by AWS. With Amplify, you can configure app backends and connect your app in minutes, deploy static web apps in a few clicks, and easily manage app content outside the AWS console.


* Add Task  Page
![12.jpeg](./12.jpeg)

* Home  Page

![13.jpeg](./13.jpeg)


# Lab 36

- Sign up page

![16.jpeg](./16.jpeg) 

- Sign in page
![14.jpeg](./14.jpeg)      ![15.jpeg](./15.jpeg) 

- Home Page 

![17.jpeg](./17.jpeg) 