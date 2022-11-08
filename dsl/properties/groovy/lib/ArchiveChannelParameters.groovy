
// DO NOT EDIT THIS BLOCK BELOW=== Parameters starts ===
// PLEASE DO NOT EDIT THIS FILE

import com.cloudbees.flowpdf.StepParameters

class ArchiveChannelParameters {
    /**
    * Label: Channel, type: entry
    */
    String channel

    static ArchiveChannelParameters initParameters(StepParameters sp) {
        ArchiveChannelParameters parameters = new ArchiveChannelParameters()

        def channel = sp.getRequiredParameter('channel').value
        parameters.channel = channel

        return parameters
    }
}
// DO NOT EDIT THIS BLOCK ABOVE ^^^=== Parameters ends, checksum: 7947036ffa6df471826089e356d1b6fb ===
