// This procedure.dsl was generated automatically
// DO NOT EDIT THIS BLOCK === procedure_autogen starts ===
procedure 'Archive Channel', description: '''Archives a conversation.''', {

    step 'Archive Channel', {
        description = ''
        command = new File(pluginDir, "dsl/procedures/ArchiveChannel/steps/ArchiveChannel.pl").text
        shell = 'ec-perl'
        shell = 'ec-perl'

        postProcessor = '''$[/myProject/perl/postpLoader]'''
    }
// DO NOT EDIT THIS BLOCK === procedure_autogen ends, checksum: bf85c6b22fb4bc0ce33c4e32ca5f99f6 ===
// Do not update the code above the line
// procedure properties declaration can be placed in here, like
// property 'property name', value: "value"
}