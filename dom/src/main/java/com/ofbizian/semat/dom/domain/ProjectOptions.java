package com.ofbizian.semat.dom.domain;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.series.Point;
import com.googlecode.wickedcharts.highcharts.options.series.PointSeries;

public class ProjectOptions extends Options {

    private static final long serialVersionUID = 1L;

    public ProjectOptions(Project project) {

        ChartOptions chartOptions = new ChartOptions()
                .setPolar(Boolean.TRUE)
                .setType(SeriesType.LINE);

        setChartOptions(chartOptions);
        setTitle(new Title(project.getName()));
        setPane(new Pane().setSize(new PixelOrPercent(90, PixelOrPercent.Unit.PERCENT)));
        setLegend(new Legend(false));
        setCredits(new CreditOptions().setEnabled(false));
        setExporting(new ExportingOptions().setEnabled(false));

        List<String> categories = new ArrayList<>();
        categories.add(project.getOpportunity().getName());
        categories.add(project.getStakeholders().getName());
        categories.add(project.getRequirements().getName());
        categories.add(project.getSoftwareSystem().getName());
        categories.add(project.getWork().getName());
        categories.add(project.getTeam().getName());
        categories.add(project.getWayOfWorking().getName());

        List<Point> points = new ArrayList<>();
        points.add(new Point(project.getOpportunityStatus(), project.getAlphaStateWeight(project.getOpportunity())));
        points.add(new Point(project.getStakeholdersStatus(), project.getAlphaStateWeight(project.getStakeholders())));
        points.add(new Point(project.getRequirementsStatus(), project.getAlphaStateWeight(project.getRequirements())));
        points.add(new Point(project.getSoftwareSystemStatus(), project.getAlphaStateWeight(project.getSoftwareSystem())));
        points.add(new Point(project.getWorkStatus(), project.getAlphaStateWeight(project.getWork())));
        points.add(new Point(project.getTeamStatus(), project.getAlphaStateWeight(project.getTeam())));
        points.add(new Point(project.getWayOfWorkingStatus(), project.getAlphaStateWeight(project.getWayOfWorking())));

        setxAxis(new Axis()
                .setCategories(categories)
                .setTickmarkPlacement(TickmarkPlacement.ON)
                .setLineWidth(0));

        setyAxis(new Axis()
                .setMin(0)
                .setMax(6)
                .setTickInterval(1.0F)
                .setLineWidth(0)
                .setGridLineInterpolation(GridlineInterpolation.POLYGON));

        setTooltip(new Tooltip().setFormatter(new Function().setFunction("return this.point.name;")));

        addSeries(new PointSeries()
                .setData(points)
                .setPointPlacement(PointPlacement.ON)
                .setType(SeriesType.AREA)
                .setName("Alphas"));
    }

    public String getLabel() {
        return "Polar chart";
    }
}
