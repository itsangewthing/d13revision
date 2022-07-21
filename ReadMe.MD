common errors:
    typoerrors
## missing curly brackets
## opening brackets
##  dollar signs

--------------

mvn spring-boot:run

mvn clean package spring-boot:run

mvn spring-boot:run -Dspring-boot.run.arguments="--port=8080"

mvn spring-boot:run -Dspring-boot.run.arguments="--port=8080 --dataDir=c:\data"

mvn clean test


--------------


##GIT COMMANDS

1. git init  (initial a local repo, doesn't link to repo yet)
2. <create a git remote repo>
3. git remote add origin http://github.com/<username>/<reponame>.git
4. git add * (add new/updated files to be commited into local repo)
5. git status (to check files that are going to commit into local repo)
6. git commit -m "<commit message>" (commit new/updated files to local repo)
7. git push -u origin master (create a master branch in github and push code to github master branch)
8. <don't develop in master branch - final/latest working baseline>
9. git checkout -b develop master (clone a copy from master to develop branch locally)
10. git push -u origin develop (push from local develop branch to github develop branch)
--------------
11. git checkout develop (to switch between branches)
12. git branch -a (show all local branches and remote branch references)
13. git branch (shows all local branches)
14. <always develop in develop branch>
15.git add * 
16. git commit -m "<commit changes>"
17. git push -u origin develop (push code on local develop branch to github develop branch)
18. git checkout master
19. git merge develop (after changes in develop branch are completed without errors, in master branch, merge changes from develop branch)
20. git push -u origin master (in master branch to push merged changes from develop branch to github master branch)

## DEPLOY TO HEROKU (MUST BE ON MASTER BRANCH LOCALLY AND REMOTE)
1. Create/use an existing heroku account
2. On your project root, you need a system.properities file. 
3. Put the following line in system.properities file.
    ## java.runtime.version=18
4. git add * 
5. git commit -m "added/updated system.properities"
6. git push -u origin master
7. heroku login (in terminal/cmd prompt in project root directory)
8. heroku apps:create
9. git remote -v  (all remote branches. you should see references url to heroku)
10. git push -u heroku master
11. THAT'S IT
12. change java version, in pom.xml from 18 to 1.8 (VAJAYJAY'S MAC ONLY )
