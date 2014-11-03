JenkinsLamp
===========

Jenkinslamps is a Java application used to control a red and a green Lava lamp, based on the the status of Jenkins builds.

The application can deployed on any computer, including the Jenkins server.

The Jenkins server is interfaced using it's REST API and the lamps are controlled using whatever OS command, configurable.

The lamps are controlled for example by a Tellstick and Nexa remote switches, but any product can be used supporting control by a OS command line program. Install whatever is bundled to your product and verify the exact command line to turn lamps on and off.

The jenkinslamps application checks the Jenkins build status periodically via the Jenkins REST-API. If any of the jobs specified in the configuration file fails, a native OS command from the configuration file is executed in order to light up the right lamp.

Outside office times the lamps are shut off. Swedish holidays are hard coded, change the code in order to adapt it to you own preferences.

A an example configuration file:

<?xml version="1.0" encoding="UTF-8"?>
<jenkinslampsConfig>
    <jenkinsUrl>http://your-ci-server:8080/</jenkinsUrl>
    <pollTimeMsec>10000</pollTimeMsec>
    <turnOn>09:00</turnOn>
    <turnOff>17:00</turnOff>
    <activeHolidays>false</activeHolidays>
    <lamps>
        <lamp>
            <name>green</name>
            <description>Turn on green lamp when job unit-test is ok</description>
            <onCommand>"C:\\Program Files (x86)\\Telldus\\tdtool.exe" --on 1</onCommand>
            <offCommand>"C:\\Program Files (x86)\\Telldus\\tdtool.exe" --off 1</offCommand>
            <jobs>
                <job>unit-test</job>
            </jobs>
            <actions>
                <whenAllJobsOk>on</whenAllJobsOk>
                <whenAnyJobFails>off</whenAnyJobFails>
                <whenAnyJobUndefined>off</whenAnyJobUndefined>
            </actions>
        </lamp>
        <lamp>
            <name>red</name>
            <description>Turn on red lamp when job unit-test has failed</description>
            <onCommand>"C:\\Program Files (x86)\\Telldus\\tdtool.exe" --on 2</onCommand>
            <offCommand>"C:\\Program Files (x86)\\Telldus\\tdtool.exe" --off 2</offCommand>
            <jobs>
                <job>unit-test</job>
            </jobs>
            <actions>
                <whenAllJobsOk>off</whenAllJobsOk>
                <whenAnyJobUndefined>off</whenAnyJobUndefined>
                <whenAnyJobFails>on</whenAnyJobFails>
            </actions>
        </lamp>
    </lamps>
</jenkinslampsConfig>

Short Receipe

    Install the Tellstick software and configure your remote switches for both lamps. Make sure you can turn them on and off from the command prompt.
    Download the jenkinslamp-x-y.zip (or build from source) and extract it into a folder, for example C:\jenkinslamps-2.0.
    Edit config.xml
    Start jenkinslamps by running jenkinslamps.bat


