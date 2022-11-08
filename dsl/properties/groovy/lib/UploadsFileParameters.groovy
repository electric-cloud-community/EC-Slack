
// DO NOT EDIT THIS BLOCK BELOW=== Parameters starts ===
// PLEASE DO NOT EDIT THIS FILE

import com.cloudbees.flowpdf.StepParameters

class UploadsFileParameters {
    /**
    * Label: Channels, type: entry
    */
    String channels
    /**
    * Label: Content, type: textarea
    */
    String content
    /**
    * Label: Title, type: entry
    */
    String title

    static UploadsFileParameters initParameters(StepParameters sp) {
        UploadsFileParameters parameters = new UploadsFileParameters()

        def channels = sp.getRequiredParameter('channels').value
        parameters.channels = channels
        def content = sp.getRequiredParameter('content').value
        parameters.content = content
        def title = sp.getParameter('title').value
        parameters.title = title

        return parameters
    }
}
// DO NOT EDIT THIS BLOCK ABOVE ^^^=== Parameters ends, checksum: ad44b9800f7c2c60428a189f19004922 ===
