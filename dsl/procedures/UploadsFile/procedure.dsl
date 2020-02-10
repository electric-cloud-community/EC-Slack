// This procedure.dsl was generated automatically
// DO NOT EDIT THIS BLOCK === procedure_autogen starts ===
procedure 'Uploads File', description: '''Uploads or creates a file.''', {

    step 'Uploads File', {
        description = ''
        command = new File(pluginDir, "dsl/procedures/UploadsFile/steps/UploadsFile.pl").text
        shell = 'ec-perl'
        shell = 'ec-perl'

        postProcessor = '''$[/myProject/perl/postpLoader]'''
    }
// DO NOT EDIT THIS BLOCK === procedure_autogen ends, checksum: 8eae375c2b23a7f9297b366a5a511aad ===
// Do not update the code above the line
// procedure properties declaration can be placed in here, like
// property 'property name', value: "value"
}