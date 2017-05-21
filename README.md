# Health Dashboard

The problem: I have many blood analysis results in pdf and I want to see them in a chart in order to see the evolution of those results.
So, I created a Java web application to display CSV data in charts.

I deployed the application on Heroku. You can see it at [https://my-health-dashboard.herokuapp.com/](https://my-health-dashboard.herokuapp.com/)

# Run

It's a **Maven** webapp, so clone or download the source code and open with your favorite IDE (I used Netbeans 8.2).
Deploy the webapp in a servlet container such as **Tomcat** and open this URL: http://localhost:8080/health-dashboard/ in your browser


# Heroku deployment

All configuration files necessary to deploy on Heroku are at the root of the repository:
- app.json
- Procfile
- system.properties

Follow these steps to setup:
```
git remote add heroku https://github.com/andrescanavesi/health-dashboard.git
heroku git:remote -a my-health-dashboard
```

And this command to deploy:
```
git push heroku master
```

# Contribute

Feel free to send pull requests