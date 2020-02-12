// This procedure.dsl was generated automatically
// DO NOT EDIT THIS BLOCK === procedure_autogen starts ===
procedure 'Create Channel', description: '''Initiates a public or private channel-based conversation''', {

    step 'Create Channel', {
        description = ''
        command = new File(pluginDir, "dsl/procedures/CreateChannel/steps/CreateChannel.pl").text
        shell = 'ec-perl'
        shell = 'ec-perl'

        postProcessor = '''$[/myProject/perl/postpLoader]'''
    }

    formalOutputParameter 'channel_id',
        description: 'the new id of the channel that created.'
// DO NOT EDIT THIS BLOCK === procedure_autogen ends, checksum: 5bac2a9ac52caec3b56fcc181a4a6a0e ===
// Do not update the code above the line
// procedure properties declaration can be placed in here, like
// property 'property name', value: "value"
}