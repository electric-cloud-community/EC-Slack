 EC-Slack Plugin  

EC-Slack
========

Plugin version 1.1.0.0

Revised on Mar 12, 2021

* * *

Contents
========

*   [Overview](#overview)
*   [Plugin Configuration](#CreateConfiguration)
*   [Plugin Procedures](#procedures)

*   [Send Realtime Message](#SendRealtimeMessage)
*   [Create Channel](#CreateChannel)
*   [Archive Channel](#ArchiveChannel)
*   [Uploads File](#UploadsFile)

*   [Release Notes](#releaseNotes)

Overview
========

This plugin integrates with Slack.

Plugin Configurations
=====================

Plugin configurations are sets of parameters that apply across some or all of the plugin procedures. They reduce repetition of common values, create predefined parameter sets for end users, and securely store credentials where needed. Each configuration is given a unique name that is entered in designated parameters on procedures that use them.  
  

### Creating Plugin Configurations

To create plugin configurations in CloudBees Flow, do these steps:

*   Go to **Administration** > **Plugins** to open the Plugin Manager.
*   Find the EC-Slack-1.0.4.0 row.
*   Click **Configure** to open the Configurations page.
*   Click **Create Configuration** as per the description of parameters below.
Configuration Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Unique name for the configuration |
| Description | Configuration description |
| **My REST Endpoint** | REST API Endpoint |
| **Bearer token** | Token to connect to... |
| HTTP Proxy | A proxy server URL that should be used for connections. |
| Proxy Authorization | Username and password for proxy. |
| Check Connection? | If checked, a connection endpoint and credentials will be tested before save. The configuration will not be saved if the test fails. |
| Debug Level | This option sets debug level for logs. If info is selected, only summary information will be shown, for debug, there will be some debug information and for trace the whole requests and responses will be shown. |

Plugin Procedures
=================

**IMPORTANT** Note that the names of Required parameters are marked in **_bold italics_** in the parameter description table for each procedure.

Send Realtime Message
---------------------

Sends a message from EF to either a Slack Channel or a user.

### Send Realtime Message Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Previously defined configuration for the plugin |
| **Channel** | Slack Channel |
| **Text** | Message Text |
| Blocks | A JSON-based array of structured blocks, presented as a URL-encoded string. |

Create Channel
--------------

Initiates a public or private channel-based conversation

### Create Channel Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Previously defined configuration for the plugin |
| **Channel Name** | Slack Channel Name |
| Is Private | Create a private channel instead of a public one |
| User IDs | list of between 1 and 30 human users that will be added to the newly-created conversation. e.g. "W1234567890,U2345678901,U3456789012" |

#### Output Parameters

| Parameter | Description |
| --- | --- |
| channel\_id | the new id of the channel that created. |
| channel\_url | the URL of the channle that created. |

Archive Channel
---------------

Archives a conversation.

### Archive Channel Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Previously defined configuration for the plugin |
| **Channel** | ID of conversation to archive. |

Uploads File
------------

Uploads or creates a file.

### Uploads File Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Previously defined configuration for the plugin |
| **Channels** | Comma-separated list of channel names or IDs where the file will be shared. |
| **Content** | File contents. |
| Title | Title of the file being shared. |

Release Notes
=============

### EC-Slack 1.1.0

*   Add output parameter to Create Channel with URL to the new channel

### EC-Slack 1.0.4

*   Add help page.

### EC-Slack 1.0.0

*   Introduced EC-Slack plugin.