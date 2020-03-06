package edu.usfca.dataflow.transforms;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PCollection;

import edu.usfca.dataflow.utils.LogParser;
import edu.usfca.protobuf.Profile.PurchaserProfile;

/**
 * Task B.
 */
public class PurchaserProfiles {

  /**
   * Input PCollection contains log messages to be parsed using {@link LogParser#getIdAndPurchaseEvent(String)}.
   *
   * (For those who didn't complete Lab 05 -- these "logs" are synthetic but their format is legit. Load balancers (that
   * route incoming traffic to your server cluster) do leave logs that look exactly like these. Indeed, I adopted
   * Google's GCP Load Balancer logs for this project.)
   *
   * These log messages are assumed to be for an n-day period (where the exact value of n is not important to us yet).
   * Just think of it as a weekly or monthly dataset.
   *
   * Output PCollection must contain "PurchaseProfile" protos, one for each PurchaseEvent.
   *
   * Aggregation of these profiles happens in a different PTransform (mainly for unit test purposes)
   * {@link MergeProfiles}.
   *
   * If {@link LogParser#getIdAndPurchaseEvent(String)} returns a null value (because the log message is
   * invalid/corrupted), then simply ignore the returned value (don't include it in your output PC).
   *
   * As such, the output PCollection will always have no more elements than the input PCollection.
   *
   * You must first define your "PurchaseProfile" proto message (see profile.proto), then build your gradle project (to
   * generate proto template Java files based on your proto file), and complete implementing this PTransform.
   *
   * NOTE: Your proto message should NOT look similar to anyone else's (if two proto messages look similar, then it's
   * likely that someone copied it), because this project requires you figure out how to design a pipline and how to
   * represent the intermediate data. As such, DO NOT share/show your proto message definitions -- it'll be pretty
   * obvious.
   *
   * NOTE2: This is somewhat similar to obtaining DeviceProfiles from BidLogs (from previous projects).
   */
  public static class GetProfilesFromEvents extends PTransform<PCollection<String>, PCollection<PurchaserProfile>> {

    @Override
    public PCollection<PurchaserProfile> expand(PCollection<String> input) {
      return null;
    }
  }

  /**
   * This is expected to be called on the output of {@link GetProfilesFromEvents} (unit tests do that, for instance).
   *
   * Given (yet-to-be-merged) PC of PurchaserProfile protos, this PTransform must combine profiles (by DeviceId).
   * 
   * It's up to you whether you choose to use GroupByKey or Combine.perKey (although Combine.perKey is recommended for
   * performance reasons).
   *
   * The logic for this PTransform will be determined based on how you defined your PurchaserProfile proto message.
   *
   * The only requirements (as far as unit tests go) are:
   *
   * (1) The output PCollection must have distinct DeviceIds (which must be valid)
   *
   * (2) "purchase_total" field's value must be correct for every PurchaserProfile (you can just sum them up; it's for
   * sanity check purposes).
   *
   * Other than these two, the grading system will NOT actually care about your PurchaserProfile protos (because it
   * doesn't know/care what you are doing with PurchaserProfile messages).
   */
  public static class MergeProfiles extends PTransform<PCollection<PurchaserProfile>, PCollection<PurchaserProfile>> {

    @Override
    public PCollection<PurchaserProfile> expand(PCollection<PurchaserProfile> input) {
      return null;
    }
  }
}
