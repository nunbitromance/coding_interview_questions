double approxRollingAverage (double avg, double new_sample) {

    avg -= avg / N;
    avg += new_sample / N;

    return avg;
}
