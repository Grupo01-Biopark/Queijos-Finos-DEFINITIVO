package com.example.demo.DTO;

public class TransferStatusProductionDTO {

    private Long producingCount;
    private Long complementationCount;
    private Long withdrawalCount;
    private Long disconnectedCount;
    
    public Long getProducingCount() {
        return producingCount;
    }
    public void setProducingCount(Long producingCount) {
        this.producingCount = producingCount;
    }
    public Long getComplementationCount() {
        return complementationCount;
    }
    public void setComplementationCount(Long complementationCount) {
        this.complementationCount = complementationCount;
    }
    public Long getWithdrawalCount() {
        return withdrawalCount;
    }
    public void setWithdrawalCount(Long withdrawalCount) {
        this.withdrawalCount = withdrawalCount;
    }
    public Long getDisconnectedCount() {
        return disconnectedCount;
    }
    public void setDisconnectedCount(Long disconnectedCount) {
        this.disconnectedCount = disconnectedCount;
    }

    public TransferStatusProductionDTO() {
        
    }

    public TransferStatusProductionDTO(Long producingCount, Long complementationCount, Long withdrawalCount,
            Long disconnectedCount) {
        this.producingCount = producingCount;
        this.complementationCount = complementationCount;
        this.withdrawalCount = withdrawalCount;
        this.disconnectedCount = disconnectedCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((producingCount == null) ? 0 : producingCount.hashCode());
        result = prime * result + ((complementationCount == null) ? 0 : complementationCount.hashCode());
        result = prime * result + ((withdrawalCount == null) ? 0 : withdrawalCount.hashCode());
        result = prime * result + ((disconnectedCount == null) ? 0 : disconnectedCount.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransferStatusProductionDTO other = (TransferStatusProductionDTO) obj;
        if (producingCount == null) {
            if (other.producingCount != null)
                return false;
        } else if (!producingCount.equals(other.producingCount))
            return false;
        if (complementationCount == null) {
            if (other.complementationCount != null)
                return false;
        } else if (!complementationCount.equals(other.complementationCount))
            return false;
        if (withdrawalCount == null) {
            if (other.withdrawalCount != null)
                return false;
        } else if (!withdrawalCount.equals(other.withdrawalCount))
            return false;
        if (disconnectedCount == null) {
            if (other.disconnectedCount != null)
                return false;
        } else if (!disconnectedCount.equals(other.disconnectedCount))
            return false;
        return true;
    }

    
}
