package FlowPlugin::Slack;
use JSON;
use strict;
use warnings;
use base qw/FlowPDF/;
use FlowPDF::Log;

# Feel free to use new libraries here, e.g. use File::Temp;

# Service function that is being used to set some metadata for a plugin.
sub pluginInfo {
    return {
        pluginName          => '@PLUGIN_KEY@',
        pluginVersion       => '@PLUGIN_VERSION@',
        configFields        => ['config'],
        configLocations     => ['ec_plugin_cfgs'],
        defaultConfigValues => {}
    };
}

# Auto-generated method for the procedure Send Realtime Message/Send Realtime Message
# Add your code into this method and it will be called when step runs
# Parameter: config
# Parameter: channel
# Parameter: text

sub sendRealtimeMessage {
    my ($pluginObject) = @_;

    my $context = $pluginObject->getContext();
    my $params = $context->getRuntimeParameters();

    my $ECSlackRESTClient = $pluginObject->getECSlackRESTClient;
    # If you have changed your parameters in the procedure declaration, add/remove them here
    my %restParams = (
        'channel' => $params->{'channel'},
        'text' => $params->{'text'},
        'blocks' => $params->{'blocks'},
    );
    my $response = $ECSlackRESTClient->SendRealtimeMessage(%restParams);
    logInfo("Got response from the server: ", $response);

    my $stepResult = $context->newStepResult;

    $stepResult->apply();
    
    if( $response->{'ok'} != 1 ) {
        die $response->{'error'};
    }
}

# This method is used to access auto-generated REST client.
sub getECSlackRESTClient {
    my ($self) = @_;

    my $context = $self->getContext();
    my $config = $context->getRuntimeParameters();
    require FlowPlugin::ECSlackRESTClient;
    my $client = FlowPlugin::ECSlackRESTClient->createFromConfig($config);
    return $client;
}
# Auto-generated method for the procedure Create Channel/Create Channel
# Add your code into this method and it will be called when step runs
# Parameter: config
# Parameter: name
# Parameter: is_private
# Parameter: user_ids

sub createChannel {
    my ($pluginObject) = @_;

    my $context = $pluginObject->getContext();
    my $params = $context->getRuntimeParameters();

    my $ECSlackRESTClient = $pluginObject->getECSlackRESTClient;
    # If you have changed your parameters in the procedure declaration, add/remove them here
    my %restParams = (
        'name' => $params->{'name'},
        'is_private' => $params->{'is_private'},
        'user_ids' => $params->{'user_ids'},
    );
    my $response = $ECSlackRESTClient->CreateChannel(%restParams);
    logInfo("Got response from the server: ", $response);

    my $stepResult = $context->newStepResult;

    if( $response->{'ok'} != 1 ) {
        die $response->{'error'};
    }

    $stepResult->setOutputParameter(channel_id => $response->{'channel'}->{'id'});

    $stepResult->apply();
}

# Auto-generated method for the procedure Uploads File/Uploads File
# Add your code into this method and it will be called when step runs
# Parameter: config
# Parameter: channels
# Parameter: content
# Parameter: title

sub uploadsFile {
    my ($pluginObject) = @_;

    my $context = $pluginObject->getContext();
    my $params = $context->getRuntimeParameters();

    my $ECSlackRESTClient = $pluginObject->getECSlackRESTClient;
    # If you have changed your parameters in the procedure declaration, add/remove them here
    my %restParams = (
        'channels' => $params->{'channels'},
        'content' => $params->{'content'},
        'title' => $params->{'title'},
    );
    my $response = $ECSlackRESTClient->UploadsFile(%restParams);
    logInfo("Got response from the server: ", $response);

    my $stepResult = $context->newStepResult;

    $stepResult->apply();
    
    if( $response->{'ok'} != 1 ) {
        die $response->{'error'};
    }
}

## === step ends ===
# Please do not remove the marker above, it is used to place new procedures into this file.


1;