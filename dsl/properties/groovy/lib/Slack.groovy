import com.cloudbees.flowpdf.*

/**
* Slack
*/
class Slack extends FlowPlugin {

    @Override
    Map<String, Object> pluginInfo() {
        return [
                pluginName     : '@PLUGIN_KEY@',
                pluginVersion  : '@PLUGIN_VERSION@',
                configFields   : ['config'],
                configLocations: ['ec_plugin_cfgs'],
                defaultConfigValues: [:]
        ]
    }

/**
     * Auto-generated method for the procedure Send Realtime Message/Send Realtime Message
     * Add your code into this method and it will be called when step runs* Parameter: config* Parameter: channel* Parameter: text
     */
    def sendRealtimeMessage(StepParameters p, StepResult sr) {
        EC-SlackRESTClient rest = getEC-SlackRESTClient()
        Map restParams = [:]
        Map requestParams = p.asMap
        restParams.put('channel', requestParams.get('channel'))
        restParams.put('text', requestParams.get('text'))

        Object response = rest.SendRealtimeMessage(restParams)
        log.info "Got response from server: $response"
        //TODO step result output parameters
        sr.apply()
    }
/**
     * This method returns REST Client object
     */
    EC-SlackRESTClient getEC-SlackRESTClient() {
        Context context = getContext()
        EC-SlackRESTClient rest = EC-SlackRESTClient.fromConfig(context.getConfigValues(), this)
        return rest
    }
// === step ends ===

}