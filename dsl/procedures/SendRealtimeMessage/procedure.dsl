// This procedure.dsl was generated automatically
// DO NOT EDIT THIS BLOCK === procedure_autogen starts ===
procedure 'Send Realtime Message', description: '''Sends a message from EF to either a Slack Channel or a user.''', {

    step 'Send Realtime Message', {
        description = ''
        command = new File(pluginDir, "dsl/procedures/SendRealtimeMessage/steps/SendRealtimeMessage.pl").text
        shell = 'ec-perl'
        shell = 'ec-perl'

        postProcessor = '''$[/myProject/perl/postpLoader]'''
    }
// DO NOT EDIT THIS BLOCK === procedure_autogen ends, checksum: c735a3889c1203c0ac07fc7a629bae91 ===
// Do not update the code above the line
// procedure properties declaration can be placed in here, like
// property 'property name', value: "value"
}