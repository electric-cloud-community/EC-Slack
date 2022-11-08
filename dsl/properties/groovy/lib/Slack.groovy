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
// === check connection ends ===
/**
     * Auto-generated method for the procedure Send Realtime Message/Send Realtime Message
     * Add your code into this method and it will be called when step runs* Parameter: config* Parameter: channel* Parameter: text* Parameter: blocks
     */
    def sendRealtimeMessage(StepParameters p, StepResult sr) {
        SendRealtimeMessageParameters sp = SendRealtimeMessageParameters.initParameters(p)
        ECSlackRESTClient rest = genECSlackRESTClient()
        Map restParams = [:]
        Map requestParams = p.asMap
        restParams.put('channel', requestParams.get('channel'))
        restParams.put('text', requestParams.get('text'))
        restParams.put('blocks', requestParams.get('blocks'))

        Object response = rest.SendRealtimeMessage(restParams)
        log.info "Got response from server: $response"

        if( response.ok != 1 ) {
            sr.setJobStepSummary(response.error)
            sr.setJobStepOutcome('error')
        }

        sr.apply()
        log.info("step sendRealtimeMessage has been finished")
    }

/**
     * This method returns REST Client object
     */
    ECSlackRESTClient genECSlackRESTClient() {
        Context context = getContext()
        ECSlackRESTClient rest = ECSlackRESTClient.fromConfig(context.getConfigValues(), this)
        return rest
    }
/**
     * Auto-generated method for the procedure Create Channel/Create Channel
     * Add your code into this method and it will be called when step runs* Parameter: config* Parameter: name* Parameter: is_private* Parameter: user_ids
     */
    def createChannel(StepParameters p, StepResult sr) {
        CreateChannelParameters sp = CreateChannelParameters.initParameters(p)
        ECSlackRESTClient rest = genECSlackRESTClient()
        Map restParams = [:]
        Map requestParams = p.asMap
        restParams.put('name', requestParams.get('name'))
        restParams.put('is_private', requestParams.get('is_private'))
        restParams.put('user_ids', requestParams.get('user_ids'))

        Object response = rest.CreateChannel(restParams)
        log.info "Got response from server: $response"

        if( response.ok != 1 ) {
            sr.setJobStepSummary(response.error)
            sr.setJobStepOutcome('error')
            sr.apply()
            return
        }

        String channelId = response.channel.id
        String channelName = requestParams.get('name')

        sr.setOutputParameter('channel_id',  channelId)

        response = rest.getTeamInfo(restParams)
        if( response.ok != 1 ) {
            sr.setJobStepSummary(response.error)
            sr.setJobStepOutcome('error')
            sr.apply()
            return
        }
        String teamId = response.team.id
        sr.setOutputParameter('channel_url', "<html><a href=\"slack://channel?id=${channelId}&team=${teamId}\">${channelName}</a></html>")

        sr.apply()
    }
/**
     * Auto-generated method for the procedure Archive Channel/Archive Channel
     * Add your code into this method and it will be called when step runs* Parameter: config* Parameter: channel
     */
    def archiveChannel(StepParameters p, StepResult sr) {
        ArchiveChannelParameters sp = ArchiveChannelParameters.initParameters(p)
        ECSlackRESTClient rest = genECSlackRESTClient()
        Map restParams = [:]
        Map requestParams = p.asMap
        restParams.put('channel', requestParams.get('channel'))

        Object response = rest.ArchiveChannel(restParams)
        log.info "Got response from server: $response"
        if( response.ok != 1 ) {
            sr.setJobStepSummary(response.error)
            sr.setJobStepOutcome('error')
        }
        sr.apply()
    }
/**
     * Auto-generated method for the procedure Uploads File/Uploads File
     * Add your code into this method and it will be called when step runs* Parameter: config* Parameter: channels* Parameter: content* Parameter: title
     */
    def uploadsFile(StepParameters p, StepResult sr) {
        UploadsFileParameters sp = UploadsFileParameters.initParameters(p)
        ECSlackRESTClient rest = genECSlackRESTClient()
        Map restParams = [:]
        Map requestParams = p.asMap
        restParams.put('channels', requestParams.get('channels'))
        restParams.put('content', requestParams.get('content'))
        restParams.put('title', requestParams.get('title'))

        Object response = rest.UploadsFile(restParams)
        log.info "Got response from server: $response"

        if( response.ok != 1 ) {
            sr.setJobStepSummary(response.error)
            sr.setJobStepOutcome('error')
        }
        sr.apply()
    }
// === step ends ===

}