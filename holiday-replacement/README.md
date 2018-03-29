# holiday replacement 
this is a simple approach to handle holiday replacement using as many camunda ready-to-use utility as possible. Please see my [blogpost](http://blog.frena.de) for further details.

picture

## run it
In this project you find a spring boot application. You can run it with `gradle bootRun` from command line.

1. go to [camunda tasklist](http://localhost:8081/app/tasklist/default/#) (user: demo | pw: demo) and start an instance of process _Holiday Replacement_. The default assignee will be user _jack_. Refresh tasklist. There should be a brand new task called _Coordinator jack_. You can also call `http://localhost:8081/tasklist?user=jack` to receive this task in browser.
2. open [camunda cockpit](http://localhost:8081/app/cockpit/default/#) and find the instance you started. Note that the assignee of the task is left empty, since only a candiate group was assigned.
3. open [camunda admin](http://localhost:8081/app/admin/default/#/) and go to _Groups_. There should be a group _group_jack_coordinator_ in wich _jack_ is the only member.
4. Do another call (in browser) `http://localhost:8081/add?substitute=john&forUserId=jack&forRole=coordinator` and check the _groups_ again in _camunda admin_. There still is group _group_jack_coordinator_ now containing two users. User _John_ was created on the fly meaning that John can now work on **all** of jacks task with this **one** configuration call. check `http://localhost:8081/tasklist?user=john`. 
5. Complete the task in cockpit. For simplification use user demo, claim the task and complete.
6. Return back to _camunda admin_. Group and users are gone, since no more task is assigned to either of them.

Feel free to play around and comment on the [post](http://blog.frena.de).

