package com.nitorcreations.metrics.wicket;

import org.apache.wicket.Session;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Histogram;

public class SessionSizeHistogramRequestCycleListener extends AbstractRequestCycleListener {

    @Override
    public void onBeginRequest(RequestCycle cycle) {
        super.onBeginRequest(cycle);

        Histogram histogram = Metrics.newHistogram(getClass(), "Session size in Bytes");
        histogram.update(Session.get().getSizeInBytes());
    }

}
