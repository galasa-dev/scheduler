/*
 * Copyright contributors to the Galasa project
 */
package cmd

import (
	"github.com/spf13/cobra"

	"galasa.dev/scheduler/pkg/status"
)
var (
    statusCmd = &cobra.Command{
		Use:   "status",
		Short: "Fetch the current status of the scheduler",
		Long:  "Report on the current configuration and what test runs are active",
		Run:   statusExecute,
	}

)

func init() {
	rootCmd.AddCommand(statusCmd)

}

func statusExecute(cmd *cobra.Command, args []string) {
	status.StatusReport()
}
