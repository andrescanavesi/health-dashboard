# Health Dashboard

The problem: I have many blood analysis results in many PDFs. Great, this PDFs are beautiful but It's difficult compare results from different dates,
so I want to display them in a chart and see the evolution of those results. Because of this I created a Java web application to display
CSV data in charts (one chart for each analysis).

I deployed the application on Heroku. You can see it at [https://my-health-dashboard.herokuapp.com/](https://my-health-dashboard.herokuapp.com/)

![Screenshot form](https://raw.githubusercontent.com/andrescanavesi/health-dashboard/master/src/main/resources/screenshot-form.png)

![Screenshot charts](https://raw.githubusercontent.com/andrescanavesi/health-dashboard/master/src/main/resources/screenshot-charts.png)


# Run

It's a **Maven** webapp, so clone or download the source code and open with your favorite IDE (I used Netbeans 8.2).
Deploy the webapp in a servlet container such as **Tomcat** and open this URL: http://localhost:8080/health-dashboard/ in your browser

# Technologies
- Java 7 (JSF)
- OpenCSV 3.9
- Primefaces 6.1

# Heroku deployment

All configuration files necessary to deploy on Heroku are at the root of the repository:
- app.json
- Procfile
- system.properties

Follow these steps to setup:
(change "my-health-dashboard" for the name of your heroku app)
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
