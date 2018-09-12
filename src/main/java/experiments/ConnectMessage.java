package experiments;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ConnectMessage implements Serializable {
    private String correlationId;
    private Integer priority;
    private Boolean compression;
    private Boolean transactionMode;
    private Integer deliveryMode;
    private Integer acknowledgementMode;
    private Integer progress;
    private Boolean stream;
    private String type;
    private Boolean enableInterop;
    private List<Serializable> payload;
    private Map<String, Date> timeBucket;

    private ConnectMessage() {
    }

    public ConnectMessage(List<Serializable> payload, String type) {

    }

    public ConnectMessage(List<Serializable> payload, String type, String correlationId) {

    }

    public ConnectMessage(List<Serializable> payload, String type, Integer progress) {

    }

    public ConnectMessage(Serializable payload, String type) {

    }

    public ConnectMessage(Serializable payload, String type, String correlationId) {

    }

    public ConnectMessage(Serializable payload, String type, Integer progress) {

    }

    public ConnectMessage(Serializable payload, Boolean interop, String type, Integer progress) {

    }

    public ConnectMessage(List<Serializable> payload, Boolean enableInterop, String type) {

    }

    public ConnectMessage(Serializable payload, Boolean enableInterop, String type) {

    }

    public ConnectMessage(String correlationId,
                          Integer priority,
                          Boolean compression,
                          Boolean transactionMode,
                          Integer deliveryMode,
                          Integer acknowledgementMode,
                          Integer progress,
                          Boolean stream,
                          Boolean enableInterop,
                          List<Serializable> payload,
                          String type) {

    }

    public ConnectMessage(String correlationId,
                          Integer priority,
                          Boolean compression,
                          Boolean transactionMode,
                          Integer deliveryMode,
                          Integer acknowledgementMode,
                          Integer progress,
                          Boolean stream,
                          Boolean enableInterop,
                          Serializable payload,
                          String type) {
    }

//    public String getCorrelationId() {
//        return correlationId;
//    }
//
//    public SenderInfo getSenderInfo() {
//        return SystemInfo.getSenderInfo(correlationId);
//    }
//
//    public void setCorrelationId(String correlationId) {
//        this.correlationId = correlationId;
//    }
//
//    public Integer getPriority() {
//        return priority;
//    }
//
//    public Boolean getCompression() {
//        return compression;
//    }
//
//    public Boolean getTransactionMode() {
//        return transactionMode;
//    }
//
//    public Integer getDeliveryMode() {
//        return deliveryMode;
//    }
//
//    public Integer getAcknowledgementMode() {
//        return acknowledgementMode;
//    }
//
//    public Integer getProgress() {
//        return progress;
//    }
//
//    public void setProgress(Integer progress) {
//        this.progress = progress;
//    }
//
//    public Boolean getStream() {
//        return stream;
//    }
//
//    public Boolean getEnableInterop() {
//        return enableInterop;
//    }
//
//    public List<Serializable> getPayload() {
//        return payload;
//    }
//
//    public Serializable getFirstPayload() throws ConnectException {
//        if (payload != null && payload.size() > 0) {
//            return payload.get(0);
//        } else {
//            throw new ConnectException("Payload is null or missing");
//        }
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void addTimeStamp(String milestone, Date timestamp) {
//        if (timeBucket == null) {
//            timeBucket = new HashMap<String, Date>();
//        }
//        timeBucket.put(milestone, timestamp);
//    }
//
//    public Map<String, Date> getTimeBucket() {
//        return timeBucket;
//    }
}
