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
// DO NOT EDIT THIS BLOCK === procedure_autogen ends, checksum: 1eff0ed608a96af12287c1e2631aa35f ===
// Do not update the code above the line
// procedure properties declaration can be placed in here, like
// property 'property name', value: "value"
}