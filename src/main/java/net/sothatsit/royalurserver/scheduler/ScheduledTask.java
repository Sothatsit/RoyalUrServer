package net.sothatsit.royalurserver.scheduler;

import net.sothatsit.royalurserver.util.Checks;
import net.sothatsit.royalurserver.util.Time;

/**
 * A task be be ran at a specific time.
 *
 * @author Paddy Lamont
 */
public class ScheduledTask extends Task {

    private final Runnable runnable;
    private final Time time;

    public ScheduledTask(String name, Runnable runnable, Time time) {
        super(name);

        Checks.ensureNonNull(runnable, "runnable");
        Checks.ensureNonNull(time, "time");

        this.runnable = runnable;
        this.time = time;
    }

    @Override
    public boolean shouldRun() {
        return time.isPast();
    }

    @Override
    public boolean willRepeat() {
        return false;
    }

    @Override
    public void runImpl() {
        runnable.run();
    }
}
