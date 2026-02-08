import {Statistic} from "./Statistic";
import {ActivityTableName} from "../Enums/ActivityTableName";

export interface TypedStatistic {
    type: ActivityTableName;
    stats: Statistic[];
}